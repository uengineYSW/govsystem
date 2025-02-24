<template>
    <div>
        <v-list two-line v-if="list.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    color="primary"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in list" :key="idx">
                    <template v-slot:default="{ active }">
                        <v-list-item-avatar color="primary-darker-1">
                        </v-list-item-avatar>
                        
                        <v-list-item-content>
                            <v-list-item-title>
                            </v-list-item-title>
                            <v-list-item-subtitle>
                                CollectionId :  {{item.collectionId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                SystemName :  {{item.systemName }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                QueryItems :  {{item.queryItems }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                QueryPeriod :  {{item.queryPeriod }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Priority :  {{item.priority }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                DataProcessingRules :  {{item.dataProcessingRules }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                VerificationStatus :  {{item.verificationStatus }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                QueryHistory :  {{item.queryHistory }}
                            </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                            <v-checkbox :input-value="active" color="primary-darker-1"></v-checkbox>
                        </v-list-item-action>
                    </template>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'DataCollectionExternalDataPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/externalData'))
            if(temp.data) {
                me.list = temp.data._embedded.externalData;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/externalData/' + id))
                if(tmpValue.data) {
                    var val = tmpValue.data
                    me.list.forEach(function(item, idx) {
                        if(item.name == val.name) {
                            me.selected = idx
                        }
                    })
                }
            }
        },
        methods: {
            select(val) {
                var obj = {}
                if(val != undefined) {
                    var arr = this.list[val]._links.self.href.split('/');
                    obj['collectionId'] = arr[4]; 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

