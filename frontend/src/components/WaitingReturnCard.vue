<template>
  <q-card flat bordered>
    <q-card-section>
      <div class="text-h6">{{ question }}</div>
    </q-card-section>

    <q-card-section class="q-pt-none">
      brabrabra
    </q-card-section>
  </q-card>
</template>

<script>
export default {
  name: "WaitingReturnCard",
  props: {
    question: String
  }
};
</script>

<style lang="scss" scoped></style>
