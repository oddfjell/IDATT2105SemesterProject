<template>
  <div class="container">
    <div id="thumbnail">
      <img alt="bird" :src=item.image>
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
  padding: 10px;
  border-radius: 10px;
  background-color: #eeeeee;
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
  width: 100%;
}
</style>