package br.ifpe.project.padroes.Strategy;

public class XPCalculoStrategy {

     double XP_PADRAO = 10d;

        public XPCalculoStrategy(double XP_PADRAO) {
            this.XP_PADRAO = XP_PADRAO;
        }

        public double calcularXPCurso(int cargaHoraria) {
            return XP_PADRAO * cargaHoraria;
        }

        public double calcularXPMentoria(double XP_PADRAO) {
            return XP_PADRAO + 20d;
        }
}
