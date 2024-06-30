package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getLinhas()][getBoard().getColunas()];

        Position p = new Position(0,0);

        //Acima
        p.setValues(position.getLinha() - 1, position.getColuna());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //Abaixo
        p.setValues(position.getLinha() + 1, position.getColuna());
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //Esquerda
        p.setValues(position.getLinha(), position.getColuna() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //Direita
        p.setValues(position.getLinha(), position.getColuna() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //Noroeste
        p.setValues(position.getLinha() - 1, position.getColuna() -1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //Nordeste
        p.setValues(position.getLinha() - 1, position.getColuna() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //Sudoeste
        p.setValues(position.getLinha() + 1, position.getColuna() - 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        //Sudeste
        p.setValues(position.getLinha() + 1, position.getColuna() + 1);
        if (getBoard().positionExists(p) && canMove(p)) {
            mat[p.getLinha()][p.getColuna()] = true;
        }

        return mat;
    }
}
