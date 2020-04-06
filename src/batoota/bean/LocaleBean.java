package batoota.bean;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
@ManagedBean(name = "localeBean")
public class LocaleBean {

	private Locale locale;
	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}

	public Locale getLocale() {
		return locale;
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

}
