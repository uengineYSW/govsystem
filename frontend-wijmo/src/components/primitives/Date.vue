<template>
    <div>
        <div v-if="editMode">
            <v-menu
                ref="menu"
                v-model="menu"
                :close-on-content-click="false"
                :return-value.sync="date"
                transition="scale-transition"
                offset-y
                min-width="auto"
            >
                <template v-slot:activator="{ on, attrs }">
                    <v-text-field
                        v-bind="attrs"
                        v-model="date"
                        :label="label"
                        prepend-icon="mdi-calendar"
                        readonly
                        v-on="on"
                    ></v-text-field>
                </template>
                <v-date-picker
                        v-model="date"
                        no-title
                        scrollable
                >
                    <v-spacer></v-spacer>
                    <v-btn text color="primary" @click="resetDate()">
                        Reset
                    </v-btn>
                    <v-btn text color="primary" @click="setDate(date)">
                        OK
                    </v-btn>
                </v-date-picker>
            </v-menu>
        </div>
        <div v-else>
            {{label}} :  {{value}}
        </div>
    </div>
</template>

<script>  
    export default {
        name: 'Date',
        components:{
        },
        props: {
            value: Object,
            editMode: Boolean,
            label: String,
        },
        data: () => ({
            menu: false,
            date: (new Date(Date.now() - (new Date()).getTimezoneOffset() * 60000)).toISOString().substr(0, 10),
        }),
        created() {
            if(!this.value) {
                this.date = null;
                this.value = this.date;
            }
        },
        mounted() {
            this.$EventBus.$on('changeSelected', (dialog) => {
                if (!dialog) {
                    this.date = null;
                }
            });
        },
        watch: {
            value() {
                this.change();
            }
        },
        methods:{
            change(){
                this.$emit("input", this.value);
            },
            resetDate(){
                this.date = null;
                this.value = this.date
                this.setDate(this.value)
            },
            setDate(date){
                this.$refs.menu.save(date)
                this.$emit("input", date);
            }
        }
    }
</script>