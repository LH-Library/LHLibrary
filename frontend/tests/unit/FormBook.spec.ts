import { mount } from '@vue/test-utils'
import FormBook from '@/components/FormBook.vue'


describe('FormBook.vue', () => {

  global.fetch = jest.fn(() => {
    Promise.resolve({
      json: () => Promise.resolve()
    })
  })

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

  it('verify type of', async () => {

    await wrapper.find("input[id='titulo']").setValue("test");
    await wrapper.find("input[id='autor']").setValue("test");
    await wrapper.find("input[id='editora']").setValue("test");
    await wrapper.find("input[id='edicao']").setValue("test");
    await wrapper.find("input[id='idioma']").setValue("test");
    await wrapper.find("input[id='paginas']").setValue(100);
    await wrapper.find("input[id='genero']").setValue("test");
    await wrapper.find("input[id='isbn']").setValue("test");
    await wrapper.find("input[id='local']").setValue("test");

  })

})
