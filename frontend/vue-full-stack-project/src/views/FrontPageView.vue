<template>
  <Header />
  <Suspense>
    <ItemGrid/>
  </Suspense>
</template>

<script>
import ItemGrid from '@/components/ItemGrid.vue'
import Header from "@/components/Header/Header.vue";

export default {
  name: "FrontpageWrapper",
  components:{ItemGrid, Header}
}
</script>

<style scoped>

</style>