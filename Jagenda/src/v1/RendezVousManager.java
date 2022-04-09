package v1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import myrendezvous.Rendezvous;
import myrendezvous.RendezvousManager;
import myrendezvous.exceptions.RendezvousNotFound;

public class RendezVousManager implements RendezvousManager, Cloneable {

	private TreeMap<Calendar, Rendezvous> treeMapRendezVous;
	

	public RendezVousManager(RendezVous rdv) {
		super();
		this.treeMapRendezVous = new TreeMap<>();
	}

	@Override
	public Rendezvous addRendezvous(Rendezvous arg0) {
		Rendezvous CopieRendezVous = clone(arg0);
		treeMapRendezVous.put(CopieRendezVous.getTime(), CopieRendezVous);
		return CopieRendezVous;
	}

	@Override
	public Calendar findFreeTime(int arg0, Calendar arg1, Calendar arg2) throws IllegalArgumentException {
		if (arg0 == 0 || arg1 == null || arg2 == null || arg1.after(arg2)) throw new IllegalArgumentException();
		
		List<Rendezvous> listeRendezVousEntre = getRendezvousBetween(arg1, arg2);
		
		if (listeRendezVousEntre == null)return arg1;
		
		for (int i = 0; i < listeRendezVousEntre.size() - 1; i++) {

			Calendar debutFreeTime = (Calendar) listeRendezVousEntre.get(i).getTime();
			debutFreeTime.add(Calendar.MINUTE, listeRendezVousEntre.get(i).getDuration());

			Calendar finRendezVous = (Calendar) debutFreeTime.clone();
			finRendezVous.add(Calendar.MINUTE, arg0);

			Calendar finFreeTime = listeRendezVousEntre.get(i + 1).getTime();

			if (finFreeTime.after(finRendezVous)) return debutFreeTime;
		}
		return null;
	}

	@Override
	public List<Rendezvous> findRendezvousByTitleALike(String arg0, Calendar arg1, Calendar arg2) {
		List<Rendezvous> listeRendezVous = getRendezvousBetween(arg1, arg2);
		if(arg1 == null) {
			listeRendezVous = getRendezvousBefore(arg2);
		}else if(arg2 == null) {
			listeRendezVous = getRendezvousAfter(arg1);
		}else if(arg1 == null && arg2 == null) {
			listeRendezVous = new ArrayList<>();
			
			for (Map.Entry<Calendar, Rendezvous> m : treeMapRendezVous.entrySet()) {
				listeRendezVous.add(m.getValue());
			}
		}
		
		List<Rendezvous> ListeRendezVousNouvelle = new ArrayList<>();
		for (int i = 0; i < listeRendezVous.size(); i++) {
			if (listeRendezVous.get(i).getTitle().equalsIgnoreCase(arg0)) {
				ListeRendezVousNouvelle.add(listeRendezVous.get(i));
			}
		}
		return ListeRendezVousNouvelle;
	}

	@Override
	public List<Rendezvous> findRendezvousByTitleEqual(String arg0, Calendar arg1, Calendar arg2) {
		List<Rendezvous> listeRendezVous = getRendezvousBetween(arg1, arg2);
		if(arg1 == null) {
			listeRendezVous = getRendezvousBefore(arg2);
		}else if(arg2 == null) {
			listeRendezVous = getRendezvousAfter(arg1);
		}else if(arg1 == null && arg2 == null) {
			listeRendezVous = new ArrayList<>();
			
			for (Map.Entry<Calendar, Rendezvous> m : treeMapRendezVous.entrySet()) {
				listeRendezVous.add(m.getValue());
			}
		}
		
		List<Rendezvous> ListeRendezVousNouvelle = new ArrayList<>();
		for (int i = 0; i < listeRendezVous.size(); i++) {
			if (listeRendezVous.get(i).getTitle().equals(arg0)) {
				ListeRendezVousNouvelle.add(listeRendezVous.get(i));
			}
		}
		return ListeRendezVousNouvelle;
	}

	@Override
	public List<Rendezvous> getRendezvousAfter(Calendar arg0) throws IllegalArgumentException {
		if (arg0 == null) throw new IllegalArgumentException();
		
		List<Rendezvous> listeRendezVousApres = new ArrayList<>();
		
		for (Map.Entry<Calendar, Rendezvous> m : treeMapRendezVous.entrySet()) {
			if (m.getKey().compareTo(arg0) == 0) listeRendezVousApres.add(m.getValue());
			if (m.getKey().compareTo(arg0) > 0) listeRendezVousApres.add(m.getValue());
		}
		return listeRendezVousApres;
	}

	@Override
	public List<Rendezvous> getRendezvousBefore(Calendar arg0) throws IllegalArgumentException {
		if (arg0 == null) throw new IllegalArgumentException();
		
		List<Rendezvous> listeRendezVousAvant = new ArrayList<>();
		
		for (Map.Entry<Calendar, Rendezvous> m : treeMapRendezVous.entrySet()) {
			if (m.getKey().compareTo(arg0) == 0) listeRendezVousAvant.add(m.getValue());
			if (m.getKey().compareTo(arg0) < 0) listeRendezVousAvant.add(m.getValue());
		}
		return listeRendezVousAvant;
	}

	@Override
	public List<Rendezvous> getRendezvousBetween(Calendar arg0, Calendar arg1) throws IllegalArgumentException {
		if (arg0 == null || arg1 == null || arg0.after(arg1)) throw new IllegalArgumentException();
		
		List<Rendezvous> listeRendezVousApres = getRendezvousAfter(arg0);
		List<Rendezvous> listeRendezVousAvant = getRendezvousBefore(arg1);
		List<Rendezvous> listeRendezVousEntre = new ArrayList<>();
		
		for (int i = 0; i < listeRendezVousApres.size() - 1; i++) {
			if(listeRendezVousApres.get(i).getTitle() == listeRendezVousAvant.get(i).getTitle()) {
				listeRendezVousEntre.add(listeRendezVousApres.get(i));
			}
		}
		return listeRendezVousEntre;
	}

	@Override
	public List<Rendezvous> getRendezvousToday() {
		List<Rendezvous> listeRendezVousToday = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for (Map.Entry<Calendar, Rendezvous> m : treeMapRendezVous.entrySet()) {
			if (calendar.compareTo(m.getValue().getTime()) == 0) {
				listeRendezVousToday.add(m.getValue());
			}
		}
		return listeRendezVousToday;
	}

	@Override
	public boolean hasOverlap(Calendar arg0, Calendar arg1) {
		List<Rendezvous> listeRendezVous = getRendezvousBetween(arg0, arg1);
		
		if (listeRendezVous == null) return false;
		
		for (int i = 0; i < listeRendezVous.size() - 1; i++) {
			Calendar condition1 = listeRendezVous.get(i).getTime();
			Calendar condition2 = listeRendezVous.get(i+1).getTime();
			if (arg0.before(condition1)) if (condition1.before(condition2))
				condition1.add(Calendar.MINUTE, listeRendezVous.get(i).getDuration());
				if(condition2.before(condition1)) if(condition2.before(arg1)) return true;
		}
		for (int i = 0; i < listeRendezVous.size() - 1; i++) {
			Calendar calendrier1 = (Calendar) listeRendezVous.get(i).getTime().clone();
			Calendar calendrier2 = (Calendar) listeRendezVous.get(i + 1).getTime().clone();
			Calendar finCalendrier1 = (Calendar) calendrier1.clone();
			if (calendrier1.before(calendrier2)) {
				finCalendrier1.add(Calendar.MINUTE, listeRendezVous.get(i).getDuration());
				if (calendrier2.before(finCalendrier1)) {
					return true;
				}
			}

		}
		return false;
	}

	@Override
	public void removeAllRendezvousBefore(Calendar arg0) throws IllegalArgumentException {
		if (arg0 == null) throw new IllegalArgumentException();
		
		List<Rendezvous> listeRendezVousAvant = getRendezvousBefore(arg0);
		
		for (int i = 0; i < listeRendezVousAvant.size() - 1; i++) {
			removeRendezvous(listeRendezVousAvant.get(i).getTime());
		}
		
	}

	@Override
	public void removeRendezvous(Rendezvous arg0) throws IllegalArgumentException, RendezvousNotFound {
		boolean rendezVousExiste = false;
		
		if (arg0 == null)throw new IllegalArgumentException();
		if (!rendezVousExiste) throw new RendezvousNotFound();
		
		for (Map.Entry<Calendar, Rendezvous> m : treeMapRendezVous.entrySet()) {
			if (m.getKey().equals(arg0.getTime())) {
				treeMapRendezVous.remove(m.getKey());
				rendezVousExiste = true;
			}
		}
	}

	@Override
	public boolean removeRendezvous(Calendar arg0) {
		for (Map.Entry<Calendar, Rendezvous> m : treeMapRendezVous.entrySet()) {
			if (m.getKey().equals(arg0)) {
				treeMapRendezVous.remove(m.getKey());
				return true;
			}
		}
		return false;
	}

	@Override
	public Rendezvous updateRendezvous(Rendezvous arg0) throws RendezvousNotFound {
		boolean rendezVousExiste = false;
		RendezVous rendezVousModifie = null;
		
		if (!rendezVousExiste) throw new RendezvousNotFound();
		
		for (Map.Entry<Calendar, Rendezvous> m : treeMapRendezVous.entrySet()) {
			if(m.getValue().getTitle() == m.getValue().getTitle()) {
				Rendezvous rendezVousUpdate = arg0;
				removeRendezvous(m.getValue());
				rendezVousModifie = (RendezVous) addRendezvous(rendezVousUpdate);		
			}
		}
		return clone(rendezVousModifie);
	}
	
	public Rendezvous clone(Rendezvous arg0) {
		try {
			arg0 = (RendezVous) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace(System.err);
			System.out.println("Impossible de cloner le rendez-vous !");
		}
		return arg0;
	}

}
