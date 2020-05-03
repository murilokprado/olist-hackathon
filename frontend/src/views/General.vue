<template>
  <div class="general">
    <h5>Minha loja</h5>
    <h6>Responda e eleve suas vendas em até 14%</h6>
    <div class="row">
      <div
        class="col-xs-12 col-sm-12 col-md-4 col-lg-6"
        style="padding: 0 8px;"
      >
        <div class="first-card">
          <div class="first-card__title">
            <div>Respostas automáticas</div>
            <div>Sem resposta</div>
          </div>
          <div class="first-card__title first-card__title--bold">
            <div>15420</div>
            <div>341</div>
          </div>
          <q-btn
            class="button"
            align="between"
            label="Responder"
            icon="comment"
            @click="$router.push('/messages')"
          />
        </div>
      </div>
      <div style="padding: 0 8px;" class="col-xs-6 col-sm-4 col-md-2 col-lg-2">
        <div class="second-card">
          <div class="row" style="height: 40px">
            <div class="col">
              <q-icon name="access_time" style="font-size: 32px;" />
            </div>
            <div class="col-8" style="font-size: 14px">
              Tempo de resposta
            </div>
          </div>
          <div class="row">
            Atual
          </div>
          <div class="row" style="font-weight: bold; font-size: 16px">
            1h e 40 min
          </div>
          <div class="row">
            Objetivo
          </div>
          <div class="row" style="font-weight: bold; font-size: 16px">
            1h
          </div>
          <div class="row">
            Conquiste
          </div>
          <div class="row" style="font-weight: bold; font-size: 16px;">
            <q-icon name="monetization_on" style="margin-top: 4px;" />300
          </div>
        </div>
      </div>
      <div style="padding: 0 8px;" class="col-xs-6 col-sm-4 col-md-2 col-lg-2">
        <div class="second-card second-card--warning">
          <div class="row" style="height: 40px">
            <div class="col">
              <q-icon name="shopping_cart" style="font-size: 32px;" />
            </div>
            <div class="col-8" style="font-size: 14px">
              Vendas
            </div>
          </div>
          <div class="row">
            Hoje
          </div>
          <div class="row" style="font-weight: bold; font-size: 16px">
            R$ 1.753,76
          </div>
          <div class="row">
            Ontem
          </div>
          <div class="row" style="font-weight: bold; font-size: 16px">
            R$ 3.7891,00
          </div>
          <div class="row">
            Conquiste
          </div>
          <div class="row" style="font-weight: bold; font-size: 16px;">
            <q-icon name="monetization_on" style="margin-top: 4px;" />500
          </div>
        </div>
      </div>
      <div class="col-xs-12 col-sm-12 col-md-4 col-lg-6" style="padding: 0 8px">
        <div class="third-card">
          <div class="row">
            <div class="col-5" style="padding-top: 12px">
              <img src="@/assets/graph.png" />
            </div>
            <div class="col" style="margin-left: 8px">
              <div
                class="row"
                style="color: #1A3B34; font-size: 18px; margin-bottom: 16px"
              >
                Maiores vendas
              </div>
              <div class="row" style="margin-bottom: 8px">
                <div class="col-2">
                  <div
                    style="background: #FFC542; border-radius: 6px; width: 20px; height: 12px; margin-top:4px"
                  ></div>
                </div>
                <div
                  class="col"
                  style="color: #899A96; font-size: 14px; text-align: left; text-align: left; margin-left: 4px;"
                >
                  Cadeira de praia
                </div>
              </div>
              <div class="row" style="margin-bottom: 8px">
                <div class="col-2">
                  <div
                    style="background: #FF575F; border-radius: 6px; width: 20px; height: 12px; margin-top:4px"
                  ></div>
                </div>
                <div
                  class="col"
                  style="color: #899A96; font-size: 14px; text-align: left; margin-left: 4px;"
                >
                  Mochila Kipling
                </div>
              </div>
              <div class="row" style="margin-bottom: 8px">
                <div class="col-2">
                  <div
                    style="background: #3DD598; border-radius: 6px; width: 20px; height: 12px; margin-top:4px"
                  ></div>
                </div>
                <div
                  class="col"
                  style="color: #899A96; font-size: 14px; text-align: left; margin-left: 4px;"
                >
                  Caixa JBL
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "General",
  data() {
    return {
      img:
        "https://h5p.org/sites/default/files/styles/medium-logo/public/logos/chart-icon-color.png?itok=kpLTYHHJ"
    };
  }
};
</script>

<style lang="scss" scoped>
.general {
  display: flex;
  flex-direction: column;
  justify-content: center;
  padding: 32px;
}

h5 {
  text-align: left;
  margin: 0;
}

.first-card {
  background: #3ed598;
  border-radius: 25px;
  padding: 16px;
  margin-bottom: 24px;
}

.first-card__title {
  display: flex;
  justify-content: space-around;
  text-align: center;
  font-size: 14px;
}

.first-card__title--bold {
  font-size: 16px;
  font-weight: bold;
}

.button {
  background: white;
  color: #3ed598;
  margin-top: 16px;
  font-size: 16px !important;
}

.second-card {
  background: #ff565e;
  border-radius: 25px;
  padding: 16px;
  margin-bottom: 24px;
}

.second-card--warning {
  background: #ffc542;
}

.third-card {
  background: #ffffff;
  box-shadow: 0px 1px 14px #19282f;
  border-radius: 25px;
  padding: 24px;
}
</style>
