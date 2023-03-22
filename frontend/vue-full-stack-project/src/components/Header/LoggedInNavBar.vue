<template>
  <nav>
    <div id="routerList">
      <router-link class="navElement" to="/">Profile</router-link>
      <router-link class="navElement" to="/">Cart</router-link>
      <router-link class="navElement" to="/newad">New ad</router-link>
    </div>
  </nav>
</template>

<script>
export default {
  name: "LoggedInNavBar"
}
</script>

<style scoped>
nav{
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}
#routerList{
  margin-right: 20px;
}
.navElement{
  float:right;
  display: block;
  color: white;
  text-align: center;
  padding: 15px 20px;
  text-decoration: none;
}
.navElement:hover{
  background-color: #555555;
}
</style>