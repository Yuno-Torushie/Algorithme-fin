package v1;
import java.util.Calendar;
import java.util.UUID;

import myrendezvous.Rendezvous;

public class RendezVous implements Rendezvous {
	
	private Calendar time;
	private int duration;
	private String title;
	private String description;
	private String tag;
	
	//Contructeur
	public RendezVous(Calendar time, int duration, String title, String description) throws IllegalArgumentException {
		super();
		if(title == null || duration == 0 || time == null) {
            throw new IllegalArgumentException();
        }
		this.time = time;
		this.duration = duration;
		this.title = title;
		this.description = description;
		this.tag = UUID.randomUUID().toString();
	}

	@Override
	public int getDuration() {
		return duration;
	}

	@Override
	public Calendar getTime() {
		return time;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getDescription() {
		return description;
	}
	
	@Override
	public void setDuration(int arg0) throws IllegalArgumentException {
		if(duration == 0) {
			throw new IllegalArgumentException();
		}
		this.duration = arg0;
		
	}

	@Override
	public void setTime(Calendar arg0) throws IllegalArgumentException {
		if(time == null) {
			throw new IllegalArgumentException();
		}
		this.time = arg0;
	}

	@Override
	public void setTitle(String arg0) throws IllegalArgumentException {
		if(title == null) {
			throw new IllegalArgumentException();
		}
		this.title = arg0;
	}

	@Override
	public void setDescription(String arg0) {
		this.description = arg0;
	}
	
	public String getTag() {
		return this.tag;
	}
	
	
}
