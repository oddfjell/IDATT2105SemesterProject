<template>
  <header>
    <a class="link" href="/"><img id="logo" src="/Logo.svg" alt=""></a>
    <a class="link" href="/"><p id="title">Muligens et marked</p></a>
  </header>
</template>

<script>
export default {
  name: "LogoHeader"
}
</script>

<style scoped>
#logo{
  width: min(50vw, 150px);
  vertical-align: middle;

}
header {
  background: #1abc9c;
  color: white;
  font-size: x-large;
}
#title{
  vertical-align: middle;
  display: inline;
  color: white;
  padding: 0;
}
.link{
  text-decoration: none;
}
@media only screen and (max-width: 350px) {
  #title{
    display: none;
  }
}
</style>