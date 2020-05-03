<template>
  <q-dialog v-model="alert" persistent>
    <q-card>
      <q-card-section class="row items-center">
        <q-avatar icon="priority_high" color="blue-grey-9" text-color="white" />
        <p style="padding-top: 42px; font-size: 18px" class="q-ml-sm">
          Ops! Ainda estamos trabalhando nesta jornada.
        </p>
      </q-card-section>

      <q-card-actions align="right">
        <q-btn flat label="Estou curioso" v-close-popup @click="onClick" />
        <q-btn
          flat
          label="Ok, tudo bem"
          v-close-popup
          @click="$router.go(-1)"
        />
      </q-card-actions>
    </q-card>
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
