<template>
  <main>
    <h1>ELO</h1>
    <div id="item_grid">
    <div class="item" @click="bop" :key="item" v-for="item in items">
    <ItemComponent/>
    </div>
    </div>
  </main>
</template>

<script>
import ItemComponent from "@/components/Item.vue";

export default {
  name: "FrontPageView.vue",
  components: {ItemComponent},
  data(){
    return{
      props:{
        items:Array
      },
      methods:{
        getevent(item){
          console.log(item)
        }
      }
    }
  },
  created() {
    this.items=[1,2,3,4,5]
  }
}

</script>

<style scoped>
#item_grid{
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-gap: 5%;
}
.item:hover{
  margin: 20px;
}

</style>