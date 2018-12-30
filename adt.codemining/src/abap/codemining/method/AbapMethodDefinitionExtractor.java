package abap.codemining.method;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.eclipse.jface.text.IDocument;

import abap.codemining.editor.AbapVisibility;
import abap.codemining.general.AbapClassSectionParser;
import abap.codemining.section.AbapPublicClassHeaderSection;
import abap.codemining.section.AbapSectionExtractor;

public class AbapMethodDefinitionExtractor {

	boolean publicSector = false;

	public AbapMethodInformation getMethodInformation(IDocument doc) {

		String content = setContentToLower(doc);

		Set<AbapMethodBody> methodBodies = getMethodBodies(content);
		return new AbapMethodInformation(null, methodBodies);
	}

	Set<AbapMethodHeader> getMethodHeaders(String content) {

		Set<AbapMethodHeader> abapMethodHeaders = new HashSet<>();

		String publicSectorString = extractPublicSector(content);

		AbapClassSectionParser publicSectionParser = new AbapClassSectionParser(AbapVisibility.PUBLIC);
		abapMethodHeaders.addAll(publicSectionParser.getMethodHeaders(publicSectorString));

		return abapMethodHeaders;
	}

	Set<AbapMethodBody> getMethodBodies(String content) {
		Set<AbapMethodBody> abapMethodBodies = new HashSet<>();

		Scanner scanner = new Scanner(content);

		AbapMethodBodyExtractor abapmethodBodyExtractor = new AbapMethodBodyExtractor();

		int linenumber = 0;
		while (scanner.hasNextLine()) {
			linenumber++;

			AbapMethodBody abapMethodBody = abapmethodBodyExtractor.extract(scanner.nextLine(), linenumber);

			if (abapMethodBody != null) {
				abapMethodBodies.add(abapMethodBody);
			}

		}

		scanner.close();

		return abapMethodBodies;
	}

	private String setContentToLower(IDocument doc) {
		String content = doc.get();
		content = content.toLowerCase().trim();
		return content;
	}

	private String extractPublicSector(String content) {
		AbapSectionExtractor abapSectionExtractor = new AbapSectionExtractor(new AbapPublicClassHeaderSection());
		return abapSectionExtractor.extract(content);
	}

}
