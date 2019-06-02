
package modelo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//Conversão automotica do tipo pelo JPA, nao e necessario usar @Convert nas entidades.
@Converter(autoApply=true)						  
public class MoedaConverter implements AttributeConverter<Moeda, String> {

	@Override
	public String convertToDatabaseColumn(Moeda moeda) 
	{
		switch (moeda) 
		{
			case REAL: 	    return "R"; 
			case DÓLAR: 	    return "D"; 
			case EURO:	    return "E"; 
                        case LIBRAS:        return "L";
                        case IENES:         return "I";
			default: throw new IllegalArgumentException("Unknown" + moeda);
		}
	}

	@Override
	public Moeda convertToEntityAttribute(String moeda) {

		switch (moeda)
		{
			case "R": return Moeda.REAL;
			case "D": return Moeda.DÓLAR;
			case "E": return Moeda.EURO;
                        case "L": return Moeda.LIBRAS;
                        case "I": return Moeda.IENES;
			default: throw new IllegalArgumentException("Unknown" + moeda);
		}
	}
}
