<template>
<div v-if="seller" class="container">
  <h5>Information about seller</h5>
  <p>Name: {{seller.firstName}} {{seller.lastName}}</p>
  <p>Email: {{seller.email}}</p>
  <p>Phone number: {{seller.phoneNumber}}</p>
  <p>Address: {{seller.address.country}} {{seller.address.city}} {{seller.address.postalCode}} </p>
  <p>Street: {{seller.address.streetName}} {{seller.address.streetNumber}}</p>

  <div id="map"></div>
</div>
</template>

<script >

import { Loader } from "@googlemaps/js-api-loader"

export default {
  name: "Seller",
  props: {
    seller: null,
  },
  mounted() {
    const loader = new Loader({
      apiKey: "AIzaSyAXaOGt6vruxTp6ojhX17lGfqt-EgLCON0",
      version: "weekly",
    });
    loader.load().then(() => {
      const map = new google.maps.Map(document.getElementById("map"), {
        center: {lat: 37.7749, lng: -122.4194},
        zoom: 8,
      });
    });
  }
}

</script>


<style scoped>
.container{
  padding: 10px;
}
h5{
  margin: 0;
  font-size: large;
}
#map{
  width: 100%;
  height: 20em;
}
</style>