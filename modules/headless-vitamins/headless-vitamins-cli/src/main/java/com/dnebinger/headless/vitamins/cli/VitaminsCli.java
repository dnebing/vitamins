package com.dnebinger.headless.vitamins.cli;

import com.dnebinger.headless.vitamins.client.dto.v1_0.Vitamin;
import com.dnebinger.headless.vitamins.client.pagination.Page;
import com.dnebinger.headless.vitamins.client.pagination.Pagination;
import com.dnebinger.headless.vitamins.client.resource.v1_0.VitaminResource;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;
import org.beryx.textio.web.RunnerData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.logging.Level;

public class VitaminsCli implements BiConsumer<TextIO, RunnerData> {
    public static void main(String[] args) {

        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
        logger.setLevel(Level.FINE);


        TextIO textIO = TextIoFactory.getTextIO();
        new VitaminsCli().accept(textIO, null);

        textIO.dispose("Bye!");
    }

    @Override
    public void accept(TextIO textIO, RunnerData runnerData) {
        TextTerminal<?> terminal = textIO.getTextTerminal();
        String initData = (runnerData == null) ? null : runnerData.getInitData();
        printGsonMessage(terminal, initData);

        while (true) {
            String command = textIO.newStringInputReader()
                    .withDefaultValue("help")
                    .read("Command");
            if (command.trim().length() < 1) {
                continue;
            }

            String[] args = command.trim().split(" ");

            switch (args[0].toLowerCase()) {
                case "help":
                    help(terminal);
                    break;
                case "quit":
                case "exit":
                    return;
                case "list":
                case "ls":
                    list(terminal);
                    break;
                case "add": case "a":
                    add(textIO, terminal);
                    break;
                case "get": case "g":
                    if ((args.length < 2) || (args[1] == null) || (args[1].trim().length()< 1)) {
                        terminal.printf("\n  get ID\n\nwhere ID is the vitamin id to retrieve.\n\n");
                    } else {
                        get(terminal, args[1]);
                    }
                    break;
                case "put":
                    if ((args.length < 2) || (args[1] == null) || (args[1].trim().length()< 1)) {
                        terminal.printf("\n  put ID\n\nwhere ID is the vitamin id to overwrite.\n\n");
                    } else {
                        put(textIO, terminal, args[1]);
                    }
                    break;
                case "patch":
                    if ((args.length < 2) || (args[1] == null) || (args[1].trim().length()< 1)) {
                        terminal.printf("\n  patch ID\n\nwhere ID is the vitamin id to update.\n\n");
                    } else {
                        patch(textIO, terminal, args[1]);
                    }
                    break;
                case "delete":
                case "del": case "rm":
                    if ((args.length < 2) || (args[1] == null) || (args[1].trim().length()< 1)) {
                        terminal.printf("\n  delete ID\n\nwhere ID is the vitamin id to delete.\n\n");
                    } else {
                        delete(textIO, terminal, args[1]);
                    }
                    break;
                default:
                    terminal.printf("Invalid command %s.\n\n", args[0]);

                    break;
            }
        }
    }

    public enum Type {
        VITAMIN, MINERAL, OTHER;
    };

    protected Vitamin readVitamin(TextIO textIO, Vitamin v) {
        Vitamin vitamin = new Vitamin();

        String id = v == null ? textIO.newStringInputReader()
                .read("ID") : textIO.newStringInputReader()
                .withDefaultValue(v.getId())
                .read("ID");

        String name = v == null ? textIO.newStringInputReader()
                .read("Name") : textIO.newStringInputReader()
                .withDefaultValue(v.getName())
                .read("Name");

        String description = v == null ? textIO.newStringInputReader()
                .withMinLength(0)
                .read("Description") : textIO.newStringInputReader()
                .withMinLength(0)
                .withDefaultValue(v.getDescription())
                .read("Description");

        String group = v == null ? textIO.newStringInputReader()
                .withMinLength(0)
                .read("Group") : textIO.newStringInputReader()
                .withMinLength(0)
                .withDefaultValue(v.getGroup())
                .read("Group");

        Type def = Type.VITAMIN;
        if (v != null) {
            switch (v.getType()) {
                case MINERAL: def = Type.MINERAL; break;
                case OTHER: def = Type.OTHER; break;
                default:
                    break;
            }
        }
        Type type = textIO.newEnumInputReader(Type.class)
                .withDefaultValue(def)
                .read("Type");

        String chemNames = v == null ? textIO.newStringInputReader()
                .withMinLength(0)
                .read("Chemical Names") : textIO.newStringInputReader()
                .withMinLength(0)
                .withDefaultValue(flatten(v.getChemicalNames()))
                .read("Chemical Names");

        String props = v == null ? textIO.newStringInputReader()
                .withMinLength(0)
                .read("Properties") : textIO.newStringInputReader()
                .withMinLength(0)
                .withDefaultValue(flatten(v.getProperties()))
                .read("Properties");

        String attribs = v == null ? textIO.newStringInputReader()
                .withMinLength(0)
                .read("Attributes") : textIO.newStringInputReader()
                .withMinLength(0)
                .withDefaultValue(flatten(v.getAttributes()))
                .read("Attributes");

        String symps = v == null ? textIO.newStringInputReader()
                .withMinLength(0)
                .read("Symptoms") : textIO.newStringInputReader()
                .withMinLength(0)
                .withDefaultValue(flatten(v.getSymptoms()))
                .read("Symptoms");

        String risks = v == null ? textIO.newStringInputReader()
                .withMinLength(0)
                .read("Risks") : textIO.newStringInputReader()
                .withMinLength(0)
                .withDefaultValue(flatten(v.getRisks()))
                .read("Risks");

        String articleId = v == null ? textIO.newStringInputReader()
                .withMinLength(0)
                .read("Article ID") : textIO.newStringInputReader()
                .withMinLength(0)
                .withDefaultValue(v.getArticleId())
                .read("Article ID");

        // populate the object...
        vitamin.setArticleId(fixString(articleId));
        vitamin.setAttributes(fixStringArray(attribs));
        vitamin.setChemicalNames(fixStringArray(chemNames));
        vitamin.setDescription(fixString(description));
        vitamin.setGroup(fixString(group));
        vitamin.setId(fixString(id));
        vitamin.setName(fixString(name));
        vitamin.setProperties(fixStringArray(props));
        vitamin.setRisks(fixStringArray(risks));
        vitamin.setSymptoms(fixStringArray(symps));

        switch (type) {
            case VITAMIN:
                vitamin.setType(Vitamin.Type.VITAMIN);
                break;
            case MINERAL:
                vitamin.setType(Vitamin.Type.MINERAL);
                break;
            default:
                vitamin.setType(Vitamin.Type.OTHER);
                break;
        }

        return vitamin;
    }

    protected String flatten(final String[] items) {
        if ((items == null) || (items.length < 1)) {
            return "";
        }

        if (items.length == 1) {
            return items[0];
        }

        return StringUtils.join(items, ',');
    }

    public void add(TextIO textIO, TextTerminal<?> terminal) {

        Vitamin vitamin = readVitamin(textIO, null);

        try {
            Vitamin v = _vitaminResource.postVitamin(vitamin);

            terminal.printf("Added vitamin %s\n", v);
        } catch (Exception e) {
            _log.error("Error creating vitamin: " + e.getMessage(), e);
            terminal.printf("Error creating vitamin: %s\n", e.getMessage());
        }
    }

    public void put(TextIO textIO, TextTerminal<?> terminal, final String id) {
        try {
            // fetch first...
            Vitamin v = _vitaminResource.getVitamin(id);

            // now that we have the current vitamin, let's ask for the update.
            Vitamin vitamin = readVitamin(textIO, v);

            v = _vitaminResource.putVitamin(id, vitamin);

            terminal.printf("Overwrote vitamin %s\n", v);
        } catch (Exception e) {
            _log.error("Error putting the vitamin: " + e.getMessage(), e);
            terminal.printf("Error putting the vitamin: %s\n", e.getMessage());
        }
    }
    public void patch(TextIO textIO, TextTerminal<?> terminal, final String id) {
        try {
            // fetch first...
            Vitamin v = _vitaminResource.getVitamin(id);

            // now that we have the current vitamin, let's ask for the update.
            Vitamin vitamin = readVitamin(textIO, v);

            v = _vitaminResource.putVitamin(id, vitamin);

            terminal.printf("Updated vitamin %s\n", v);
        } catch (Exception e) {
            _log.error("Error updating the vitamin: " + e.getMessage(), e);
            terminal.printf("Error updating the vitamin: %s\n", e.getMessage());
        }
    }
    public void delete(TextIO textIO, TextTerminal<?> terminal, final String id) {
        try {
            // fetch first...
            Vitamin v = _vitaminResource.getVitamin(id);

            boolean del = textIO.newBooleanInputReader().read("Do you really want to delete " + v);

            if (del) {
                _vitaminResource.deleteVitamin(id);
                terminal.printf("Deleted vitamin %s\n", v);
            }
        } catch (Exception e) {
            _log.error("Error deleting the vitamin: " + e.getMessage(), e);
            terminal.printf("Error deleting the vitamin: %s\n", e.getMessage());
        }
    }


    protected String fixString(final String given) {
        if (given == null) return null;

        if (given.trim().length()< 1) return null;

        if ("X".equals(given.trim())) {
            return null;
        }

        return given.trim();
    }

    protected String[] fixStringArray(final String given) {
        if (given == null) return null;
        if (given.trim().length() < 1) return null;

        if ("X".equals(given.trim())) {
            return null;
        }

        String[] parts = given.trim().split(",");

        for (int idx = 0; idx < parts.length; idx++) {
            parts[idx] = parts[idx].trim();
        }

        return parts;
    }

    public void list(final TextTerminal<?> terminal) {
        // use the client to get the list...
        Pagination pagination = Pagination.of(0,20);

        try {
            Page<Vitamin> vitaminPage = _vitaminResource.getVitaminsPage(null,null,pagination,null);
            Collection<Vitamin> vitamins = vitaminPage.getItems();

            if ((vitamins != null) && (! vitamins.isEmpty())) {
                for (Vitamin vitamin : vitamins) {
                    terminal.printf("  Vitamin: %s\n", vitamin);
                }
            } else {
                terminal.printf("  No vitamins found!\n");
            }
        } catch (Exception e) {
            terminal.printf("Error getting list: %s\n", e.getMessage());
            _log.error("Error getting list: " + e.getMessage(), e);
        }
    }

    public void get(final TextTerminal<?> terminal, final String id) {
        terminal.printf("\nGetting %s\n\n", id);

        try {
            Vitamin vitamin = _vitaminResource.getVitamin(id);

            terminal.printf("Vitamin: %s\n", vitamin);
        } catch (Exception e) {
            terminal.printf("Error getting vitamin: %s\n", e.getMessage());
            _log.error("Error getting vitamin " + id + ": " + e.getMessage(), e);
        }
    }

    public void help(final TextTerminal<?> terminal) {
        terminal.printf("\nCommands:\n\n");
        terminal.printf("  help:   Show this text.\n");
        terminal.printf("  quit:   Exit the program.\n");
        terminal.printf("  list:   List all of the vitamins.\n");
        terminal.printf("  add:    Add a new vitamin.\n");
        terminal.printf("  get:    Gets an individual vitamin.\n");
        terminal.printf("  put:    Uses the put to replace a vitamin.\n");
        terminal.printf("  patch:  Uses the patch to update part of a vitamin.\n");
        terminal.printf("  delete: Deletes the vitamin.\n\n");
    }

    public static void printGsonMessage(TextTerminal<?> terminal, String initData) {
        if(initData != null && !initData.isEmpty()) {
            String message = new Gson().fromJson(initData, String.class);
            if(message != null && !message.isEmpty()) {
                terminal.println(message);
            }
        }
    }

    private static VitaminResource _vitaminResource = VitaminResource.builder().build();
    private static final Logger _log = LoggerFactory.getLogger(VitaminsCli.class);
}
