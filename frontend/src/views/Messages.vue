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
    <div class="actions" v-if="activeType === 'pendentes'">
      <div class="actions__item" @click="$router.push('/building')">
        Responder em massa
      </div>
      <div class="actions__item" @click="$router.push('/building')">
        Excluir mensagem
      </div>
    </div>
    <div v-if="showPending">
      <h5 id="pendentes">Pendentes</h5>
      <div class="messages__amount">
        {{ pendingQuestions.length }} mensagens
      </div>
      <div class="row" v-if="pendingQuestions.length > 0">
        <div
          v-for="q in pendingQuestions"
          :key="q.id"
          class="col-xs-12 col-sm-6 col-md-4 col-lg-4"
        >
          <h6>{{ q.product }}</h6>
          <div class="custom-card">
            <WaitingReturn v-bind="{ ...q }" />
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
        {{ answeredQuestions.length }} mensagens
      </div>
      <div class="row" v-if="answeredQuestions.length > 0">
        <div
          v-for="q in answeredQuestions"
          :key="q.id"
          class="col-xs-12 col-sm-6 col-md-4 col-lg-4"
        >
          <h6>{{ q.product }}</h6>
          <div class="custom-card">
            <Answered v-bind="{ ...q }" />
          </div>
        </div>
      </div>
      <div v-else class="placeholder">
        <h5>Não há nada por aqui :D</h5>
      </div>
    </div>
    <div v-if="showAnswered">
      <h5 id="respondidas">Respondidas Automaticamente</h5>
      <div class="messages__amount">{{ botQuestions.length }} mensagens</div>
      <div class="row" v-if="botQuestions.length > 0">
        <div
          v-for="q in botQuestions"
          :key="q.id"
          class="col-xs-12 col-sm-6 col-md-4 col-lg-4"
        >
          <h6>{{ q.product }}</h6>
          <div class="custom-card">
            <Answered v-bind="{ ...q }" />
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
          v-for="q in deletedMessages"
          :key="q.id"
          class="col-xs-12 col-sm-6 col-md-4 col-lg-4"
        >
          <h6>{{ q.product }}</h6>
          <div class="custom-card">
            <WaitingReturn v-bind="{ ...q }" />
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
import Answered from "@/components/AnsweredCard";
import { answeredQuestions, botQuestions, pendingQuestions } from "@/mock";

export default {
  name: "Messages",
  components: {
    WaitingReturn,
    Answered
  },
  data() {
    return {
      pendingQuestions,
      answeredQuestions,
      botQuestions,
      activeType: "todas",
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
  margin-bottom: 42px;
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

.actions {
  display: flex;
  justify-content: flex-start;
}

.actions__item {
  font-size: 14px;
  color: rgba(255, 255, 255, 0.4);
  cursor: pointer;
  margin-right: 16px;
  margin-bottom: 16px;
}
</style>
