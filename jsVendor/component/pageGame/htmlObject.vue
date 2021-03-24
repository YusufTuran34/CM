<template>
  <samp>
    <span @click="$emit('click-item', elements)" v-if="readyForAddElement != null">
      Buraya Ekle
    </span>
    <div v-for="element in elements">
      <div v-if="element.el == 'div'" :class="element.class">
        <html-object v-if="element.subelement != null"
                     :elements="element.subelement"
                     @click-item="$emit('click-item', $event)"
                     @text-change="$emit('text-change', $event)"></html-object>
      </div>
      <label  @dblclick="$emit('text-change', element)" v-else-if="element.el == 'label'  && element.text != null"> {{element.text}} </label>
      <p      @dblclick="$emit('text-change', element)" v-else-if="element.el == 'p'      && element.text != null"> {{element.text}} </p>
      <legend @dblclick="$emit('text-change', element)" v-else-if="element.el == 'legend' && element.html != null" v-html="element.html"></legend>
    </div>
  </samp>
</template>

<script>
export default {
  name: "htmlObject",
  props:{
    elements : Array
  },
  methods:{
    clicked(){
      this.$emit("click-item",this.elements);
    },
  },
  computed: {
    readyForAddElement(){
      return this.$store.state.element
    }
  }

}
</script>

<style scoped>

</style>