<template>
  <div class="home">
    <q-pull-to-refresh @refresh="refresh">
      <Main />
    </q-pull-to-refresh>
  </div>
</template>

<script>
// @ is an alias to /src
import Main from "@/components/Main.vue";

export default {
  name: "Home",
  components: {
    Main
  },
  methods: {
    refresh(done) {
      setTimeout(() => {
        done();
      }, 1000);
    }
  }
};
</script>
