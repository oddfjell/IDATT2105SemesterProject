<template>
  <div id="container">
    <label>{{label}}</label>
    <input id="filePicker" @change="onChange" class="field" type="file" accept="image/jpeg, image/png, image/jpg" multiple >
  </div>
</template>

<script>
export default {
  name: "ImagePicker",
  listOfImages:Array,
  props:{
    label:String,
  },
  methods:{
    onChange(event){
      this.listOfImages=event.target.files
      console.log(this.listOfImages)
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