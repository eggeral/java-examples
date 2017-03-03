package egger.software.at_mockito;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.exceptions.verification.TooManyActualInvocations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class MockitoExamples {

    @Test
    public void basicHowTo() {
        // given
        Database db = mock(Database.class);
        when(db.nextId()).thenReturn(25);
        Library library = new Library(db);

        // when
        library.registerBook(new Book("Der Hobbit"));

        // then
        verify(db).insert("BOOK", 25, "Der Hobbit");
    }

    @Test
    public void stubbingHowTo() {
        // given
        Database db = mock(Database.class);
        when(db.nextId()).thenReturn(25);

        System.out.println("nextId() 1. " + db.nextId());
        System.out.println("nextId() 2. " + db.nextId());
        System.out.println("select " + db.select("BOOK", 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionsHowTo() {
        // given
        Database db = mock(Database.class);
        when(db.nextId()).thenThrow(
                new IllegalArgumentException("Book title already exists!"));
        Library library = new Library(db);

        // when
        library.registerBook(new Book("Der Hobbit"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionOnVoidMethodHowTo() {
        // given
        Database db = mock(Database.class);
        when(db.nextId()).thenReturn(25);
        doThrow(new IllegalArgumentException()).when(db).insert("BOOK", 25,
                "Der Hobbit");
        Library library = new Library(db);

        // when
        library.registerBook(new Book("Der Hobbit"));
    }

    @Test
    public void multipleReturnValueHowTo() {
        // given
        Database db = mock(Database.class);
        when(db.nextId()).thenReturn(25).thenReturn(26);
        Library library = new Library(db);

        // when
        library.registerBook(new Book("Der Hobbit"));
        library.registerBook(new Book("Der Herr der Ringe"));

        // then
        verify(db).insert("BOOK", 25, "Der Hobbit");
        verify(db).insert("BOOK", 26, "Der Herr der Ringe");
    }

    @Test
    public void argumentMatchersHowTo() {
        // given
        Database db = mock(Database.class);
        when(db.select(eq("BOOK"), anyInt())).thenReturn("Der Hobbit");
        Library library = new Library(db);

        // when
        Book result = library.findBookById(25);

        // then
        assertThat(result.getTitle(), is("Der Hobbit"));
        verify(db).select(eq("BOOK"), eq(25));

    }

    @Test(expected = TooManyActualInvocations.class)
    public void invokeOnlyOnceHowTo() {
        // given
        Database db = mock(Database.class);
        when(db.select("BOOK", 25)).thenReturn("Der Hobbit");
        Library library = new Library(db);

        // when
        library.findBookById(25);
        library.findBookById(25);

        // then
        verify(db).select(anyString(), anyInt());
    }

    @Test
    public void invokeTwoTimesHowTo() {
        // given
        Database db = mock(Database.class);
        when(db.select("BOOK", 25)).thenReturn("Der Hobbit");
        Library library = new Library(db);

        // when
        library.findBookById(25);
        library.findBookById(25);

        // then
        verify(db, times(2)).select(anyString(), anyInt());
    }

    @Test
    public void invocationOrderHowTo() {
        // given
        Database db = mock(Database.class);

        when(db.nextId()).thenReturn(25);
        Library library = new Library(db);

        // when
        library.registerBook(new Book("Der Hobbit"));

        // then
        InOrder inOrder = inOrder(db);
        inOrder.verify(db).nextId();
        inOrder.verify(db).insert("BOOK", 25, "Der Hobbit");
    }

    @Test
    public void answerHowTo() {
        // given
        Database db = mock(Database.class);
        when(db.select(eq("BOOK"), anyInt())).thenAnswer(new Answer<String>() {

            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                int id = invocation.getArgument(1);
                if (id == 25)
                    return "Der Hobbit";
                return "Der Herr der Ringe";
            }

        });
        Library library = new Library(db);

        // when
        Book book = library.findBookById(25);

        // then
        assertThat(book.getTitle(), is("Der Hobbit"));

    }

    @Test
    public void spyOnRealObject() {
        // given
        Database db = mock(Database.class);
        Library library = new Library(db);
        Library spy = spy(library);
        doReturn(new Book("Der Hobbit")).when(spy).findBookById(25);

        // when
        Book book = spy.findBookById(25);

        // then
        assertThat(book.getTitle(), is("Der Hobbit"));

    }

}
