import { defineStore } from 'pinia'

export const Itemstore = defineStore({
    id: 'Itemstore',
    state: () => ({
        selectedItem: null
    }),
    actions: {
        selectItem(item) {
            console.log(item.image)
            this.selectedItem = item
        }
    }
})