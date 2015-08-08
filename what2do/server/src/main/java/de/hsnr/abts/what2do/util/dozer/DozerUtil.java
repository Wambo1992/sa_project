package de.hsnr.abts.what2do.util.dozer;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class DozerUtil {
	public static <T> List dozerMapCollections(List<T> source, Class dest) {
		List list = new ArrayList();
		DozerBeanMapper mapper = getMapper();
		for(T t : source) {
			list.add(mapper.map(t, dest));
		}
		return list;
	}
	
	public static DozerBeanMapper getMapper() {
		ArrayList<String> list = new ArrayList<String>();	
		list.add("dozer.xml");
		return new DozerBeanMapper(list);	
	}
}
