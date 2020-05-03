<template>
  <q-dialog v-model="alert">
    <q-card style="padding: 24px 24px 0 24px">
      <p>
        Ops! Ainda estamos trabalhando nesta jornada.
        <q-card-actions>
          <q-btn align="right" flat label="Estou curioso" @click="onClick" />
          <q-btn
            align="right"
            flat
            label="Ok, tudo bem"
            @click="$router.go(-1)"
          />
        </q-card-actions></p
    ></q-card>
  </q-dialog>
</template>

<script>
export default {
  name: "BuildingModal",
  data() {
    return {
      alert: true
    };
  },
  methods: {
    onClick() {
      window.open(
        "https://www.figma.com/proto/mtiRRDixIwUcTqXCxB6svK/Olist?node-id=7%3A1287&scaling=scale-down"
      );
    }
  }
};
</script>

<style lang="scss" scoped>
a {
  color: rgba(255, 255, 255, 0.2);
}
</style>
