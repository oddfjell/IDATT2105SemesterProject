<template>
<div id="item-page">
  <div id="image">
    <img :src="item.image" alt="">
  </div>
  <h1 id="title">{{item.title}}</h1>
  <h2 id="price">{{item.price}}</h2>
  <p id="full-description">{{item.description}}</p>
  <button>AddToCart</button>
</div>
</template>

<script>
import { Itemstore } from '../stores/selectedItem'
import {computed} from "vue";
export default {
  setup() {
    const store = Itemstore()
    const item = computed(()=>store.$state.selectedItem)
    console.log(item)
    return {
      item
    }
  },
  name: "ItemView",
  }

</script>

<style scoped>
#image img{
  width: 100%;
}
</style>