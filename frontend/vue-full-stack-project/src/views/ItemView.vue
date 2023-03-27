<template>
  <Header />
  <back-header tabindex="1" />
<div id="item-page">
  <div id="image">
    <img :src="item.image" alt="">
  </div>
  <div class="flex">
    <h1 id="title">{{item.title}}</h1>
    <h1 id="price">{{priceText}}</h1>
  </div>
  <h4 id="brief-description">{{item.briefDescription}}</h4>
  <p id="full-description">{{item.description}}</p>
  <Seller v-if="seller" :seller="seller" />
  <div class="flex">

  <button id="buyBtn" tabindex="0" @click="addToCart">AddToCart</button>
  </div>
</div>
</template>

<script>
import { Itemstore } from '@/stores/selectedItem'
import {computed} from "vue";
import BackHeader from "@/components/Header/backHeader.vue";
import Header from "@/components/Header/Header.vue";
import Seller from "@/components/Seller.vue";
import userService from "@/services/userService";
import itemService from "@/services/itemService";
import {useTokenStore} from "@/stores/token";
export default {
  components: {Seller, BackHeader, Header},
  setup() {
    const store = Itemstore()
    const item = computed(()=>store.$state.selectedItem)
    return {
      item
    }
  },
  async mounted(){
    try {
      let response = await userService.getUser(this.item.user, useTokenStore().jwtToken)
      this.seller = response.data
    }catch (e){
      console.log(e)
    }
  },
  name: "ItemView",
  item:{
    type:Object
  },
  data(){
    return{
      seller:null,
    }
  },
  methods:{
    addToCart(){
      itemService.
      alert("You added " + this.item.title + " to the cart")
    }
  },
  computed:{
    priceText(){
      return this.item.price + " kr"
    }
  },
  }

</script>

<style scoped>
#item-page{
  width: 60%;
  margin: auto auto 5%;
}
#image img{
  width: 80%;
}
#image{
  text-align: center;
}
#price{
  margin-left: auto;
  margin-right: 0;
}

.flex{
  display: flex;
}

#buyBtn{
  margin-right: 0;
  margin-left: auto;
  padding: 1.5%;
  background-color:#1abc9c;
  border-radius: 5px;
  font-size: large;
}
#buyBtn:hover{
  background-color: #5cf1e9;
  cursor: pointer;
}
</style>