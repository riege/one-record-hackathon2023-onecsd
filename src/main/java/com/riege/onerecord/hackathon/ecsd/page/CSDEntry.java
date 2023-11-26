package com.riege.onerecord.hackathon.ecsd.page;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Locale;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.link.DownloadLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.lang.Bytes;
import org.apache.wicket.util.string.StringValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;

import com.riege.onerecord.hackathon.ecsd.ECSDApplication;
import com.riege.onerecord.hackathon.ecsd.ECSDSession;
import com.riege.onerecord.hackathon.ecsd.domain.Form2SecDecConverter;
import com.riege.onerecord.hackathon.ecsd.domain.OneRecordConnector;
import com.riege.onerecord.hackathon.ecsd.domain.OneRecordDomainUtil;
import com.riege.onerecord.hackathon.ecsd.domain.SecurityCheckJob;
import com.riege.onerecord.hackathon.ecsd.onerecordCargo.SecurityDeclaration;
import com.riege.onerecord.hackathon.ecsd.wicket.HTML5DateTextField;
import com.riege.onerecord.hackathon.ecsd.wicket.HTML5TimeTextField;

/**
 * Page for all loading and unload of a truck, as well as for full exected
 * freight as for loading/unloading a discrepancy.
 */
@WicketHomePage
public class CSDEntry extends WebPage {

    private final Logger logger = LoggerFactory.getLogger(CSDEntry.class);
    private SecurityCheckJob sc;

    // Note: List<FileUpload> does not work here because not serializable
    private final Model<ArrayList<FileUpload>> uploadModel = new Model<ArrayList<FileUpload>>();
    // Fields for the form:
    private final Model<String> dateModel = new Model<>();
    private final Model<String> timeModel = new Model<>();
    private final Model<Integer> piecesModel = new Model<>();

    private final Model<String> remarkModel = new Model<>();

    private DownloadLink downloadLink;
    private File eCSDpdf = null;

    public CSDEntry() {
        String loid = parameterString("loid");
        if (loid != null) {
            sc = SecurityCheckJob.loadData(loid);
            getSession().setSecurityCheckJob(sc);
        } else {
            // generate Demo/default data
            sc = getSession().getSecurityCheckJob();
        }
        checkParameter();
        initWicketPage();

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        add(new Label("year", currentYear == 2023
                ? "2023"
                : "2023-" + currentYear));
    }

    protected final Logger getLogger() {
        return logger;
    }

    public ECSDSession getSession() {
        return (ECSDSession) Session.get();
    }

    public ECSDApplication getWebApplication() {
        return ECSDApplication.getWebApplication();
    }

    @Override
    protected void onBeforeRender() {
        super.onBeforeRender();
        Application.get().getMarkupSettings().setStripWicketTags(true);
    }

    @Override
    protected void onAfterRender() {
        super.onAfterRender();
    }

    private void checkParameter() {
        SecurityCheckJob job = SecurityCheckJob.create();
        String b64 = parameterString("id");
        if (b64 != null) {
            String decoded = new String(Base64.getDecoder().decode(b64));
            for (String tupel : decoded.split("&")) {
                String key = tupel.split("=")[0];
                String val = tupel.split("=")[1].replace("\r", "\n").replaceAll("\n\n","\n");
                if (key.equals("w")) {
                    job.setWaybillNumber(val);
                } else if (key.equals("o")) {
                    job.setOrigin(val);
                } else if (key.equals("d")) {
                    job.setDestination(val);
                } else if (key.equals("p")) {
                    job.setPartyIssueingRegulatedEntityNumber(val);
                } else if (key.equals("n")) {
                    job.setNatureOfGoods(val);
                } else if (key.equals("s")) {
                    job.setSecurityStatus(val);
                } else if (key.equals("m")) {
                    job.setScreeningMethod(val);
                }
            }
        } else {
            job.setWaybillNumber(parameterString("w"));
            job.setOrigin(parameterString("o"));
            job.setDestination(parameterString("d"));
            job.setPartyIssueingRegulatedEntityNumber(parameterString("p"));
            job.setNatureOfGoods(parameterString("n"));
            job.setSecurityStatus(parameterString("s"));
            job.setScreeningMethod(parameterString("m"));
        }

        if (job.getOrigin() != null) {
            getSession().setSecurityCheckJob(job);
            sc = getSession().getSecurityCheckJob();
        }
    }

    private StringValue parameterValue(String name) {
        return getRequestCycle().getRequest().getRequestParameters().getParameterValue(name);
    }

    private String parameterString(String name) {
        StringValue value = parameterValue(name);
        return value.isNull() || value.isEmpty() ? null : value.toString();
    }

    private void initWicketPage() {

        // Form. Note we don't overwrite
        //   protected void onSubmit()
        // on the form but on individual buttons.
        // reason is that the "go to discrepancy"-button
        // also needs to access the date/time entered
        // therefore the form needs to be submitted as well
        // so the standard "store" button-onSubmit needs to handle the
        // storing instead of the form-onSubmit
        Form<?> entryForm = new Form<>("entryForm");
        entryForm.setMultiPart(true);   // required for file upload

        TextField<String> issField = new TextField<>(
            "partyIssueingRegulatedEntityNumber",
            new PropertyModel<>(sc, "partyIssueingRegulatedEntityNumber")
        );
        issField.setRequired(true);
        entryForm.add(issField);

        entryForm.add(new TextField<>(
            "waybillNumber",
            new PropertyModel<>(sc, "waybillNumber")
        )
        .setRequired(true)
        .setEnabled(sc.getWaybillNumber() == null)
        );

        entryForm.add(new TextArea<>(
            "natureOfGoods",
            new PropertyModel<>(sc, "natureOfGoods")
        )
        .setRequired(true)
        .setEnabled(sc.getNatureOfGoods() == null)
        );

        entryForm.add(new TextField<>(
            "origin",
            new PropertyModel<>(sc, "origin")
            )
            .setRequired(true)
            .setEnabled(sc.getOrigin() == null)
        );

        entryForm.add(new TextField<>(
            "destination",
            new PropertyModel<>(sc, "destination")
            )
            .setRequired(true)
            .setEnabled(sc.getDestination() == null)
        );

        entryForm.add(new TextField<>(
            "securityStatus",
            new PropertyModel<>(sc, "securityStatus")
        ).setRequired(true));

        entryForm.add(new TextField<>(
            "screeningMethod",
            new PropertyModel<>(sc, "screeningMethod")
        ).setRequired(true));

        boolean yesWeAreLive = false;
        // yesWeAreLive = true;
        entryForm.add(new TextField<>(
            "statusIssuedBy",
            new PropertyModel<>(sc, "statusIssuedBy")
        ).setRequired(yesWeAreLive));

        dateModel.setObject(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
        timeModel.setObject(LocalTime.now().format(DateTimeFormatter.ISO_LOCAL_TIME).substring(0, 5));

        entryForm.add(new HTML5DateTextField("dateEntry", dateModel).setRequired(yesWeAreLive));
        entryForm.add(new HTML5TimeTextField("timeEntry", timeModel).setRequired(yesWeAreLive));

        // podPicture but only for API 1.1
        FileUploadField fileUpload =
                new FileUploadField("podPicture", uploadModel);
        fileUpload.setVisibilityAllowed(false);
        // limit picture upload to 10MB
        // Note: it might be required to set the limit in the web-server too, e.g.
        //       nginx.ingress.kubernetes.io/proxy-body-size
        // Since 2022-Aug-15, the nginx limit is 100MB, see
        //       https://github.com/riege/cluster-environments/pull/231/files
        entryForm.setMaxSize(Bytes.megabytes(10));
        entryForm.add(fileUpload);

        final WebMarkupContainer downloadContainer = new WebMarkupContainer("DownloadContainer");
        downloadLink = new DownloadLink("downloadPDF",
            createPDFFileModel(),
            new PropertyModel<>(CSDEntry.this, "PDFFilename"));
        downloadContainer.add(downloadLink);
        downloadContainer.setVisibilityAllowed(false);
        add(downloadContainer);

        Button storeData = new Button("storeData") {
            @Override
            public void onSubmit() {
                try {
                    if (dateModel.getObject() != null && timeModel.getObject() != null) {
                        LocalDateTime timestamp = LocalDateTime.of(
                            LocalDate.parse(dateModel.getObject(), DateTimeFormatter.ISO_DATE),
                            LocalTime.parse(timeModel.getObject(), DateTimeFormatter.ISO_LOCAL_TIME)
                        );
                        sc.setStatusIssuedOn(timestamp);
                    }
                    entryForm.setVisibilityAllowed(false);
                    this.setVisibilityAllowed(false);
                    storeData();
                    downloadContainer.setVisibilityAllowed(true);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        storeData.setVisibilityAllowed(true);
        entryForm.add(storeData);

        add(entryForm);
        /*
        try {
            checkFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */
    }

    // used by
    // new PropertyModel<>(CSDEntry.this, "PDFFilename"))
    public String getPDFFilename() {
        return "eCSD_" + sc.getWaybillNumber() + ".pdf";
    }

    private String emptyIfNull(String value) {
        return value == null ? "" : value;
    }

    public IModel<File> createPDFFileModel() {
        return new PropertyModel<File>(this, "eCSDpdf");
        /*
        return new AbstractReadOnlyModel<File>() {
            public File getObject() {
                return eCSDpdf;
            }
        };
         */
    }

    private void storeData() throws IOException {
        Logger logger = LoggerFactory.getLogger(CSDEntry.class);

        SecurityDeclaration declaration = Form2SecDecConverter.convert(sc);

        logger.info(OneRecordDomainUtil.buildJSON(declaration));

        OneRecordConnector connector = new OneRecordConnector();
        connector.sendSecurityDeclaration(declaration);

        //upload SecurityDeclaration
        // get token via endpoint: POST https://3p5ind9upy.us-east-1.awsapprunner.com/realms/neone/protocol/openid-connect/token
        // parameters:
        //  - grant_type: client_credentials
        //  - client_id: neone-client

        // POST LO to:
        // LO endpoint: https://hkrps7vtam.us-east-1.awsapprunner.com/logistics-objects
        // with Authorization Bearer token
        // Content-type: application/ld+json


        InputStream file =
            WebApplication.get().getServletContext().getResourceAsStream("e-consignment-security-declaration.pdf");

        PDDocument doc = Loader.loadPDF(StreamUtils.copyToByteArray(file));

        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        PDPage page = doc.getPage(0);
        PDPageContentStream contents = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true);

//        float h = page.getMediaBox ().getHeight ();
//        float w = page.getMediaBox ().getWidth ();
//        System.out.println (h + " x " + w + " in internal units");
//        h = h / 72 * 2.54f * 10;
//        w = w / 72 * 2.54f * 10;
//        System.out.println (h + " x " + w + " in mm");
//
//        h = page.getMediaBox ().getHeight ();
//        w = page.getMediaBox ().getWidth ();
        /*
792.0 x 612.0 in internal units
279.4 x 215.9 in mm
         */
//        int times = 20;
//        for (int i = 0; i < times; i++) {
//            float x = w * i / times;
//            float y = h * i / times;
//            contents.beginText();
//            contents.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 8);
//            contents.newLineAtOffset(x, y);
//            contents.setNonStrokingColor (Color.BLUE);
//            contents.showText("x=" + x + " y=" + y + " lower left, rect=16x16");
//            contents.endText();
//            contents.setStrokingColor (Color.RED);
//            contents.addRect (x, y, 16, 16);
//            contents.stroke();
//        }


        contents.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 10);
        contents.setNonStrokingColor (Color.BLUE);
        contents.beginText();
        contents.newLineAtOffset(180, 632);
        // contents.showText("xx/RA/nnnnn-nnnn");
        contents.showText(emptyIfNull(sc.getPartyIssueingRegulatedEntityNumber()));
        contents.endText();

        contents.beginText();
        contents.newLineAtOffset(360, 632);
        // contents.showText("NNN-NNNNNNNN");
        contents.showText(emptyIfNull(sc.getWaybillNumber()));
        contents.endText();

        String[] multiLine = emptyIfNull(sc.getNatureOfGoods())
            .replace("\r\n", "\n")
            .split("\n");
        for (int i = 0; i < multiLine.length; i++) {
            contents.beginText();
            contents.newLineAtOffset(180, 604-i*10);
            contents.showText(multiLine[i]);
            contents.endText();
        }

        contents.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 16);
        contents.beginText();
        contents.newLineAtOffset(140, 544);
        contents.setNonStrokingColor (Color.BLUE);
        contents.showText(emptyIfNull(sc.getOrigin()));
        contents.endText();

        contents.beginText();
        contents.newLineAtOffset(250, 544);
        contents.setNonStrokingColor (Color.BLUE);
        contents.showText(emptyIfNull(sc.getDestination()));
        contents.endText();

        contents.beginText();
        contents.newLineAtOffset(80, 460);
        contents.setNonStrokingColor (Color.BLUE);
        contents.showText(emptyIfNull(sc.getSecurityStatus()));
        contents.endText();

        contents.beginText();
        contents.newLineAtOffset(320, 460);
        contents.setNonStrokingColor (Color.BLUE);
        contents.showText(emptyIfNull(sc.getScreeningMethod()));
        contents.endText();

        contents.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 10);

        contents.beginText();
        contents.newLineAtOffset(190, 360);
        contents.showText(emptyIfNull(sc.getStatusIssuedBy() == null ? "" : sc.getStatusIssuedBy()));
        contents.endText();

        contents.beginText();
        contents.newLineAtOffset(408, 360);
        String issueDate = sc.getStatusIssuedOn() == null
            ? ""
            : String.format("%02d%s%02d",
                sc.getStatusIssuedOn().getDayOfMonth(),
                sc.getStatusIssuedOn().getMonth().getDisplayName(TextStyle.SHORT, Locale.US),
                sc.getStatusIssuedOn().getYear() % 100);
        contents.showText(issueDate);
        contents.endText();

        contents.beginText();
        contents.newLineAtOffset(488, 360);
        String issueTime = sc.getStatusIssuedOn() == null
            ? ""
            : String.format("%02d%02d",
                sc.getStatusIssuedOn().getHour(),
                sc.getStatusIssuedOn().getMinute());
        contents.showText(issueTime);
        contents.endText();

        // **************************************

//        byte[] bytes = IOUtils.toByteArray(signature);
//        PDImageXObject pdimage = PDImageXObject.createFromByteArray(doc, bytes, "signature");
//        contents.drawImage(pdimage, 350, 255);

        contents.close();

        eCSDpdf = File.createTempFile("ecsd", ".pdf");
        try {
            OutputStream os = new FileOutputStream(eCSDpdf);
            doc.save(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        doc.close();
    }

}
