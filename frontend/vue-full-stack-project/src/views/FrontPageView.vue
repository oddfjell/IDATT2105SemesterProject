
<template>
  <main>
    <h1>Her kommer det evt. en søkebar</h1>
    <div id="item_grid">
      <div class="item" :key="item.title" v-for="(item,index) in items">
        <ItemComponent :tabindex="index+1" :item="item" v-on:keyup.enter="selectItem(item)" @click="selectItem(item)"/>
      </div>
    </div>
  </main>
</template>

<script>
import ItemComponent from "@/components/Item.vue";
import router from "@/router";

import {Itemstore} from '@/stores/selectedItem'
import itemApi from "@/services/itemApi";

export default {
  name: "FrontPageView.vue",
  components: {ItemComponent},
  data(){
    return{
    }
  },
  methods:{
    selectItem(item){
      console.log(item)
      router.push("/item")
      this.store.selectItem(item)
    }
  },
  async setup() {
    let items=[]
    let getItems = await itemApi.getItems()
    for(let item of getItems){
      items.unshift(item)
    }
    const store = Itemstore()
    return{
      store, items
    }
  },
  created() {
    let additionalItems=[
      {title:"Bird", price:100, briefDescription:"This is a bird", description:"This is a longer text that says bird",image:"https://ctl.s6img.com/society6/img/T4B1_3uYoossKHshTuH-AWt3I2I/w_1500/prints/~artwork/s6-original-art-uploads/society6/uploads/misc/dd1abcfa933c48e982c730c3cc154cf2/~~/yellow-red-lovebird-lovebird-bird-pets-cute-cute-bird-yellow-lovebird-yellow-bird-prints.jpg"},
      {title:"Dog", price:200, briefDescription:"This is a dog", description:"This is a longer text that says dog",image:"https://thumbs.dreamstime.com/b/happy-dog-puppy-smiling-colored-blue-backgorund-closed-eyes-happy-dog-puppy-smiling-colored-blue-backgorund-193236837.jpg"},
      {title:"Cat", price:1000, briefDescription:"This is a cat", description:"This is a longer text that says cat",image:"https://i.ytimg.com/vi/YSHDBB6id4A/maxresdefault.jpg"},
      {title:"Capybara", price:9999, briefDescription:"Capybara", description:"This is a longer text that says capybara",image:"https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Capybara_%28Hydrochoerus_hydrochaeris%29.JPG/1200px-Capybara_%28Hydrochoerus_hydrochaeris%29.JPG"},]
    for(let item of additionalItems){
      this.items.push(item)
    }
  }
}

</script>

<style scoped>

#item_grid{
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-gap: 2%;
  margin-left: 5%;
  margin-right: 5%;
}
.item{
  height: fit-content;
  width: fit-content;
}
.item:hover{
  border: solid #1abc9c 4px;
  border-radius: 10px;
}
@media only screen and (max-width: 800px) {
  #item_grid{
    grid-template-columns: 1fr 1fr 1fr
  }

}

@media only screen and (max-width: 600px) {
  #item_grid{
  grid-template-columns: 1fr 1fr}
}

@media only screen and (max-width: 350px) {
  #item_grid{
    grid-template-columns: 1fr }
}
</style>