<template>
  <label v-if="label"> {{ label }} </label>
  <input
      v-bind="$attrs"
      :value="modelValue"
      :placeholder="label"
      @input="$emit('update:modelValue', $event.target.value)"
  />
  <p id="error" v-if="error">{{ error }}</p>
</template>

<script>
export default {
  name:"Base-input",
  props: {
    label: {
      type: String,
      default: "",
    },
    error: {
      type: String,
      default: "",
    },
    modelValue: {
      type: [String, Number],
      default: "",
    },
  },
};
</script>

<style scoped>
#error {
  color: red;
  font-size: small;
}
</style>