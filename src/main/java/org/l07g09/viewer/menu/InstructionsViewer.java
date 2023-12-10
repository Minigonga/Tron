package org.l07g09.viewer.menu;

import org.l07g09.gui.GUI;
import org.l07g09.model.Position;
import org.l07g09.model.menu.Instructions;
import org.l07g09.viewer.Viewer;

public class InstructionsViewer extends Viewer<Instructions> {
    public InstructionsViewer(Instructions Instructions) {
        super(Instructions);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawBoldText(new Position(14, 2), "Instructions", "#FFD700");
        String s1="TRON E UM JOGO EM QUE DOIS JOGADORES ";
        String s2="CONTROLAM UMA MOTO E DEIXAM UM RASTRO ";
        String s3="PELA AREA DE JOGO. SE ALGUEM TOCAR NO ";
        String s4="RASTRO(INCLUINDO O SEU), PERDE.";
        String s5="JOGO FEITO EM BEST OF SEVEN ";
        String s6="(PRIMEIRO A GANHAR 4 JOGOS)";
        gui.drawText(new Position(1, 6), s1, "#FFFFFF");
        gui.drawText(new Position(1, 7), s2, "#FFFFFF");
        gui.drawText(new Position(1, 8), s3, "#FFFFFF");
        gui.drawText(new Position(1, 9), s4, "#FFFFFF");
        gui.drawText(new Position(5, 11), s5, "#FFFFFF");
        gui.drawText(new Position(5, 12), s6, "#FFFFFF");
        String player1="PLAYER 1";
        String player2="PLAYER 2";
        String move="Move";
        String w="W";
        String asd="ASD";
        String jump1="JUMP: SPACE";
        String boost1="BOOST: X";
        String arrow="ARROW KEYS";
        String jump2="JUMP: L";
        String boost2="BOOST: P";
        gui.drawText(new Position(3, 16), player1, "#FFFFFF");
        gui.drawText(new Position(5, 17), move, "#FFFFFF");
        gui.drawText(new Position(7, 18), w, "#FFFFFF");
        gui.drawText(new Position(6, 19), asd, "#FFFFFF");
        gui.drawText(new Position(2, 20), jump1, "#FFFFFF");
        gui.drawText(new Position(2, 21), boost1, "#FFFFFF");
        gui.drawText(new Position(27, 16), player2, "#987654");
        gui.drawText(new Position(29, 17), move, "#987654");
        gui.drawText(new Position(26, 18), arrow, "#987654");
        gui.drawText(new Position(27, 20), jump2, "#987654");
        gui.drawText(new Position(27, 21), boost2, "#987654");
        String esc="CLIQUE NO ESC PARA VOLTAR AO MENU";
        gui.drawText(new Position(3, 27), esc, "#FFFFFF");
    }
}