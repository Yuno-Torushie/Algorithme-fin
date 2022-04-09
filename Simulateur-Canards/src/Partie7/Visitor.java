package Partie7;

public interface Visitor {
	public void visit(Troupe t);
	public void visit(Colvert c);
	public void visit(Mandarin c);
	public void visit(Appelant c);
	public void visit(CanardEnPlastique c);
	public void visit(AdaptateurDOie c);
	public void visit(CompteurDeCouacs c);
	public void visit(Visitable c);

}
