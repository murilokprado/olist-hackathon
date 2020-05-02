<template>
  <div class="messages">
    <div class="types">
      <div
        class="types__item"
        :class="{ 'types__item--active': isActive('todas') }"
        @click="onChangeActiveType('todas')"
      >
        Todas
      </div>
      <div
        class="types__item"
        :class="{ 'types__item--active': isActive('pendentes') }"
        @click="onChangeActiveType('pendentes')"
      >
        Pendentes
      </div>
      <div
        class="types__item"
        :class="{ 'types__item--active': isActive('respondidas') }"
        @click="onChangeActiveType('respondidas')"
      >
        Respondidas
      </div>
      <div
        class="types__item"
        :class="{ 'types__item--active': isActive('excluidas') }"
        @click="onChangeActiveType('excluidas')"
      >
        Excluídas
      </div>
    </div>
    <div v-if="showPending">
      <h5 id="pendentes">Pendentes</h5>
      <div class="messages__amount">{{ pendingMessages.length }} mensagens</div>
      <div class="row" v-if="pendingMessages.length > 0">
        <div
          v-for="i in pendingMessages"
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
      <div v-else class="placeholder">
        <h5>Não há nada por aqui :D</h5>
      </div>
    </div>
    <div v-if="showAnswered">
      <h5 id="respondidas">Respondidas</h5>
      <div class="messages__amount">
        {{ answeredMessages.length }} mensagens
      </div>
      <div class="row" v-if="answeredMessages.length > 0">
        <div
          v-for="i in answeredMessages"
          :key="i"
          class="col-xs-12 col-sm-6 col-md-4 col-lg-4"
        >
          <div class="custom-card">
            <WaitingReturn :question="`question ${i}`" />
          </div>
        </div>
      </div>
      <div v-else class="placeholder">
        <h5>Não há nada por aqui :D</h5>
      </div>
    </div>
    <div v-if="showDeleted">
      <h5 id="deleted">Excluídas</h5>
      <div class="messages__amount">{{ deletedMessages.length }} mensagens</div>
      <div class="row" v-if="deletedMessages.length > 0">
        <div
          v-for="i in deletedMessages"
          :key="i"
          class="col-xs-12 col-sm-6 col-md-4 col-lg-4"
        >
          <div class="custom-card">
            <WaitingReturn :question="`question ${i}`" />
          </div>
        </div>
      </div>
      <div v-else class="placeholder">
        <h5>Não há nada por aqui :D</h5>
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
  },
  data() {
    return {
      activeType: "todas",
      pendingMessages: [1, 2, 3, 4],
      answeredMessages: [1, 2, 3, 4],
      deletedMessages: []
    };
  },
  computed: {
    showPending() {
      return this.activeType === "todas" || this.activeType === "pendentes";
    },
    showAnswered() {
      return this.activeType === "todas" || this.activeType === "respondidas";
    },
    showDeleted() {
      return this.activeType === "todas" || this.activeType === "excluidas";
    }
  },
  methods: {
    isActive(type) {
      return this.activeType === type;
    },
    onChangeActiveType(newType) {
      this.activeType = newType;
    }
  }
};
</script>

<style lang="scss" scoped>
.types {
  display: flex;
  justify-content: space-around;
  margin-bottom: 58px;
}

.types__item {
  color: rgba(255, 255, 255, 0.4);
  cursor: pointer;
  font-size: 14px;
}

.types__item--active {
  color: white;
  text-decoration-line: underline;
}

.messages {
  padding: 32px;
}

.messages__amount {
  text-align: left;
  font-size: 12px;
  color: #96a7af;
  margin-bottom: 16px;
}

.custom-card {
  margin: 0 4px 16px 4px;
}

.placeholder {
  color: #96a7af;
  padding-top: 32px;
}
</style>
