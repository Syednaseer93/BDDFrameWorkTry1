package WaitConcept.WaitConcept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.RandomStringUtils;
import org.checkerframework.checker.units.qual.s;

public class Test {

	public static void main(String[] args) {
	String str="abbioHddd";
	StringBuilder sb=new StringBuilder();
	str.chars().distinct().forEach(s->sb.append((char)s));
	System.out.println(sb);

	}

	
	}
