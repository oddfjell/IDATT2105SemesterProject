<template>
  <div id="form">

    <div>
      <form>
        <label>Title</label><br>
        <textarea id="text-area" rows="5" cols="100"></textarea>
      </form>
    </div>

    <button @click="myMethod">Create ad</button>

  </div>
</template>

<script>
export default {
  name: "NewAdView.vue",
  methods: {
    myMethod() {
      console.log("Hello world!")
    }
  }
}
</script>