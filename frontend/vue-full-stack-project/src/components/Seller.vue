<template>
<div v-if="seller" class="container">
  <h5>Information about seller</h5>
  <p>Name: {{seller.firstName}} {{seller.lastName}}</p>
  <p>Email: {{seller.email}}</p>
  <p>Phone number: {{seller.phoneNumber}}</p>

  <p>Address: {{address.country}} {{address.city}} {{address.postalCode}} </p>
  <p>Street: {{address.streetName}} {{address.streetNumber}}</p>

  <div id="map"></div>
</div>
</template>

<script >

import { Loader } from "@googlemaps/js-api-loader"

export default {
  name: "Seller",
  props: {
    seller: null,
    address:null,
    latitude:0,
    longitude:0,
  },
  mounted() {

    const loader = new Loader({
      apiKey: "AIzaSyAXaOGt6vruxTp6ojhX17lGfqt-EgLCON0",
      version: "weekly",
    });
    loader.load().then(async () => {
      const apiKey = "AIzaSyAXaOGt6vruxTp6ojhX17lGfqt-EgLCON0";
      const address = this.address.country+ this.address.city + this.address.streetName + this.address.streetNumber;
      const apiUrl = `https://maps.googleapis.com/maps/api/geocode/json?address=${address}&key=${apiKey}`;
      let latitude
      let longitude
      await fetch(apiUrl)
          .then(response => response.json())
          .then(data => {
            const location = data.results[0].geometry.location;
            latitude = location.lat;
            longitude = location.lng;
          })
          .catch(error => {
            console.error(`Error: ${error}`);
          });
      const map = new google.maps.Map(document.getElementById("map"), {
        center: {lat: latitude, lng: longitude},
        zoom: 15,
      });
      const marker = new google.maps.Marker({
        position: { lat: latitude, lng: longitude },
        map: map,
        title: "Your marker title"
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