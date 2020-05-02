<template>
  <div class="messages">
    <h5>Aguardando</h5>
    <div class="row">
      <div
        v-for="i in [1, 2, 3, 4]"
        :key="i"
        class="col-xs-12 col-sm-6 col-md-4 col-lg-4"
      >
        <h6>Cadeira de praia</h6>
        <div class="custom-card">
          <WaitingReturn
            buyer="Matheus V. Valenza"
            question="Existe algum óleo próprio para lubrificar a cadeira após sair da praia?"
            dateTime="20 de março 16:20"
          />
        </div>
      </div>
    </div>
    <h5>Respostas automáticas</h5>
    <div class="row">
      <div
        v-for="i in [1, 2, 3, 4, 5, 6, 7]"
        :key="i"
        class="col-xs-12 col-sm-6 col-md-4 col-lg-4"
      >
        <div class="custom-card">
          <WaitingReturn :question="`question ${i}`" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import WaitingReturn from "@/components/WaitingReturnCard";

export default {
  name: "Messages",
  components: {
    WaitingReturn
  }
};
</script>

<style lang="scss" scoped>
.messages {
  padding: 32px;
}

.custom-card {
  margin: 0 4px 16px 4px;
}
</style>
