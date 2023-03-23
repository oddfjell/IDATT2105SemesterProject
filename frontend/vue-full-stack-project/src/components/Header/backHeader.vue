<template>
<div>
  <router-link id="backBtn" to="/"><img src="public/icons/left-arrow.svg" alt=""></router-link>
</div>
</template>

<script>
export default {
  name: "backHeader"
}
</script>

<style scoped>
div{
  margin: 1%;
}
#backBtn{
  width: 100%;
}
</style>