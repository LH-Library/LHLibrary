import { mount } from '@vue/test-utils'
import FormBook from '@/components/FormBook.vue'
import fetch, {Response} from 'node-fetch';


describe('FormBook.vue', () => {

  const data =  { 
    book: {
      titulo: "string",
      autor: "string",
      editora: "string",
      edicao: "string",
      idioma: "string",
      paginas: 1,
      genero: "string",
      status: "string",
      isbn: "string",
      ativo: "string",
      local: "string"
    }
  }

  global.fetch = jest.fn(() => {
    Promise.resolve({
      json: () => Promise.resolve(data)
    })
  }) as jest.Mock;

  const mockRoute = {
    params: {
      id: null
    }
  }

  const wrapper = mount(FormBook, {
    global: {
      mocks: {
        $route: mockRoute
      }
    }
  });

  it('verify type of', () => {

    // expect(wrapper.find("input[id='titulo']").).toBe("string");

  })

})
