<template>
  <div class="row">
    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" style="padding: 6px;">
      <div class="progress">
        <img src="@/assets/emoji-2-off.png" alt="Sr. Cadastro" />
        <div class="progress__left">
          <div style="display: flex; flex: 1; justify-content: space-between">
            <div class="progress__title">20% off na mensalidade</div>
            <div class="progress__coins">
              <q-icon name="monetization_on" /> 1200
            </div>
          </div>
          <p style="flex: 1" class="progress__subtitle">
            Cadastro completo dos produtos
          </p>
        </div>
      </div>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" style="padding: 6px;">
      <div class="progress">
        <img src="@/assets/emoji-frete-gratis.png" alt="Frete grátis" />
        <div class="progress__left">
          <div style="display: flex; flex: 1; justify-content: space-between">
            <div class="progress__title">Frete grátis por um mês</div>
            <div class="progress__coins">
              <q-icon name="monetization_on" /> 700
            </div>
          </div>
          <p style="flex: 1" class="progress__subtitle">
            Responder em menos de 1h
          </p>
        </div>
      </div>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" style="padding: 6px;">
      <div class="progress">
        <img src="@/assets/emoji-adiantar-valores.png" alt="Frete grátis" />
        <div class="progress__left">
          <div style="display: flex; flex: 1; justify-content: space-between">
            <div class="progress__title">Adiantar valor das vendas</div>
            <div class="progress__coins">
              <q-icon name="monetization_on" /> 300
            </div>
          </div>
          <p style="flex: 1" class="progress__subtitle">
            Cadastrar 20 perguntas e respostas
          </p>
        </div>
      </div>
    </div>
    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-4" style="padding: 6px;">
      <div class="progress">
        <img src="@/assets/emoji-sacar.png" alt="Frete grátis" />
        <div class="progress__left">
          <div style="display: flex; flex: 1; justify-content: space-between">
            <div class="progress__title">Sacar R$50</div>
            <div class="progress__coins">
              <q-icon name="monetization_on" /> 3000
            </div>
          </div>
          <p style="flex: 1" class="progress__subtitle">
            Ver relatório por 7 dias seguidos
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Progress"
};
</script>

<style lang="scss" scoped>
.progress {
  background: #30444e;
  display: flex;
  border-radius: 12px;
  width: 100%;
  margin-right: 12px;
}

.progress__left {
  padding: 12px;
  display: flex;
  justify-content: space-between;
  flex-direction: column;
  align-content: space-between;
  text-align: left;
  flex: 1;
}

.progress__left p {
  padding: 0;
  margin: 0;
}

.progress__title {
  font-size: 14px;
}

.progress__subtitle {
  font-size: 12px;
  color: rgba(255, 255, 255, 0.6);
}

.progress img {
  width: 70px;
}

.progress__coins {
  display: flex;
  color: #ffc542;
  align-items: center;
  text-align: right;
}
</style>
