import { defineStore } from 'pinia'

export const Itemstore = defineStore({
    id: 'Itemstore',
    state: () => ({
        selectedItem: null
    }),
    actions: {
        selectItem(item) {
            this.selectedItem = item
        }
    }
})