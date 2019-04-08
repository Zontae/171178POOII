package modelo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//Conversão automotica do tipo pelo JPA, nao e necessario usar @Convert nas entidades.
@Converter(autoApply=true)						  
public class StatusConverter implements AttributeConverter<Status, String> {

	@Override
	public String convertToDatabaseColumn(Status status) 
	{
		switch (status) 
		{
			case ATIVO: 	    return "A"; 
			case INATIVO: 	    return "I"; 
			case PREMIUM:	    return "P"; 
                        case FREEMIUM:      return "F";
			default: throw new IllegalArgumentException("Unknown" + status);
		}
	}

	@Override
	public Status convertToEntityAttribute(String status) {

		switch (status)
		{
			case "A": return Status.ATIVO;
			case "I": return Status.INATIVO;
			case "P": return Status.PREMIUM;
                        case "F": return Status.FREEMIUM; 
			default: throw new IllegalArgumentException("Unknown" + status);
		}
	}

}