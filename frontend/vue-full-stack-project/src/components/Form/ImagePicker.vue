<template>
  <div id="container">
    <label>{{label}}</label>
    <input id="filePicker" @change="onChange" class="field" type="file" accept="image/jpeg, image/png, image/jpg" >
  </div>
</template>

<script>
export default {
  name: "ImagePicker",
  image:Function,
  props:{
    label:String,
  },
  methods:{
    onChange(event){
      this.image=event.target.file
    }
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