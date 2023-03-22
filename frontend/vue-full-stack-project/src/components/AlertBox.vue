<template>
  <div id="popup" :style="{display : popupData.display}" @click="closeFunction">
    <div class="inner">
      <div class="header">
        <div>{{popupData.header}}</div>
      </div>
      <div class="body">{{popupData.body}}</div>
      <div class="footer">{{popupData.footer}}</div>
    </div>
  </div>
</template>

<script>
export default {
  props : ["popupData"],
  methods : {
    closeFunction(){
      this.popupData.display = "none";
    }
  }
}
</script>

<style>
html,body{
  padding: 0;
  margin:0;
}
#popup{
  position: absolute;
  width: 100%;
  height :100%;
  top: 0;
}
#popup .inner{
  background-color: green;
  position: inherit;
  top: 10%;
  left: 39%;
  width: 300px;
}
#popup .inner div{
  text-align: left;
}
#popup .inner .header{
  display: flex;
  justify-content: space-between;
}
</style>



<!--
<template>
  <p></p>
  <div class="alert">
    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
    <strong>{{alertMessage}}</strong>
  </div>
</template>

<script>
export default {
  name: "AlertWrongLogin.vue",
  props: {
    alertMessage: String
  }
}
</script>

<style scoped>
.alert {
  padding: 20px;
  background-color: #f44336;
  color: white;
}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
}
</style>-->
