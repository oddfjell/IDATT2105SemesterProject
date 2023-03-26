<template>
  <div class="container">
    <div id="thumbnail">
      <img v-if="item.image" alt="" :src=item.image>
    </div>
    <div id="item-header">
  <label id="title">{{item.title}}</label>
  <p id="price">{{ price }}</p>
    </div>
  <p id="description">{{item.briefDescription}}</p>
  </div>
</template>

<script>
export default {
  name: "Item-component",
  props: {
    item: {
      type: Object,
      required: true
    },
  },
    computed:{
    price(){
      return this.item.price + " kr"
    }
    }
}
</script>

<style scoped>
.container{
  margin-top: 0;
  margin-bottom: 0;
  padding: 10px;
  border-radius: 5px;
  background-color: #eeeeee;
}
#thumbnail {
  height: 100px;
}


label{
  font-size: x-large;
  font-weight: bold;
}
#price{
  margin: 0;
  float: right;
  font-weight: bold;
}
img{
  height: 100px;
  margin-left: auto;
  margin-right: auto;
  display: block;

}
</style>