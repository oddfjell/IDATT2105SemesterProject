<template>
  <div>
  <label v-if="label"> {{ label }} </label>
  <input
      v-bind="$attrs"
      :type="type"
      :value="modelValue"
      :placeholder="label"
      @input="$emit('update:modelValue', $event.target.value)"
  />
  <p id="error" v-if="error">{{ error }}</p>
  </div>
</template>

<script>
export default {
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
    type:[String,Number]
  },
};
</script>

<style scoped>
input{
  width: 100%;
  margin: auto;
  vertical-align: center;
  padding: 3%;

}
label{

  margin: auto;
  display: block;
  vertical-align: center;
}
#error {
  color: red;
  font-size: small;
}
</style>