package com.web.prog4td.Service;

import com.lowagie.text.DocumentException;
import com.web.prog4td.Configuration.PdfParserUtils;
import com.web.prog4td.Model.request.RequestedCompanyInformation;
import com.web.prog4td.Model.request.RequestedEmployee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.IOException;
import java.io.OutputStream;

@Service
@AllArgsConstructor
@Getter
@Setter
public class PDFGeneratingService {
    private final PdfParserUtils utils;
    public String parseThymeleafTemplate(RequestedEmployee user, RequestedCompanyInformation company) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        Context context = new Context();
        context.setVariable("user", user);
        context.setVariable("company", company);
        return utils.processTemplate("toPdf",context);
    }
    public void generatePdfFromHtml(String html, OutputStream stream) throws DocumentException, IOException {
        ITextRenderer renderer = new ITextRenderer();
        ClassPathResource resource = new ClassPathResource("static/assets/");
        renderer.getSharedContext().setBaseURL(resource.getURL().toString());
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(stream);
    }
}
