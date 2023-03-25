<template>
  <div id="container">
    <label>{{label}}</label>
    <input id="filePicker" class="field" type="file" accept="image/jpeg, image/png, image/jpg"  >
  </div>
</template>

<script>
export default {
  name: "ImagePicker",
  props:{
    label:String
  }

}
</script>

<style scoped>
label{

  margin: auto;
  display: block;
  vertical-align: center;
}
#filePicker{
  margin: 10px;
}
</style>