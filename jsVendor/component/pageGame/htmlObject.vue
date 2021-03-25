<template>
  <div class="active-show-border">
    <span @click="$emit('click-item', {element : elements, order: 'first'})" v-if="readyForAddElement != null">
      Ekle
    </span>
    <span @click="$emit('remove-item', elements)" v-if="readyForAddElement == null && readyToDelete == true">
      Sil
    </span>
    <div v-for="element in elements">
      <div v-if="element.el == 'div'" :class="element.class">
        <html-object v-if="element.subElement != null"
                     :elements="element.subElement"
                     @click-item="$emit('click-item', $event)"
                     @remove-item="$emit('remove-item', $event)"
                     @text-change="$emit('text-change', $event)"></html-object>
      </div>

      <label @dblclick="$emit('text-change', element)"
             v-if="element.el == 'label'  && element.text != null"> {{ element.text }} </label>
      <p @dblclick="$emit('text-change', element)"
         v-if="element.el == 'p'      && element.text != null"> {{ element.text }} </p>
      <legend @dblclick="$emit('text-change', element)"
              v-if="element.el == 'legend' && element.html != null" v-html="element.html"></legend>
    </div>
    <span @click="$emit('click-item', {element : elements, order: 'last'})" v-if="readyForAddElement != null">
      Ekle
    </span>
  </div>
</template>
<script>
export default {
  name: "htmlObject",
  data:function (){
    return {

    }
  },
  props:{
    elements : Array
  },
  methods:{

  },
  computed: {
    readyForAddElement(){
      return this.$store.state.element
    },
    readyToDelete(){
      return this.$store.state.readyToDelete
    }
  },
}
</script>

<style scoped>

</style>