<template>
  <div class="container">
    <div id="thumbnail">
      <img alt="bird" src="https://ctl.s6img.com/society6/img/T4B1_3uYoossKHshTuH-AWt3I2I/w_1500/prints/~artwork/s6-original-art-uploads/society6/uploads/misc/dd1abcfa933c48e982c730c3cc154cf2/~~/yellow-red-lovebird-lovebird-bird-pets-cute-cute-bird-yellow-lovebird-yellow-bird-prints.jpg">
    </div>
    <div id="item-header">
  <label id="title">En fugl</label>
  <p id="price">Pris: 500kr</p>
    </div>
  <p id="description">Dette er en beskrivelse</p>
  </div>
</template>

<script>
export default {
  name: "Item-component",
  data(){
    return{

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