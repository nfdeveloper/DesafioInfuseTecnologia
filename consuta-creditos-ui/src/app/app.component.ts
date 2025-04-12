import { Component, OnInit } from '@angular/core';

import { Credito } from './core/model/credito.model';
import { CreditoService } from './core/services/credito.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

interface TipoPesquisa {
  label: string,
  valor: string
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent{

  creditos: Credito[] = [];
  pesquisa: string = "";
  tipoPesquisaSelecionado = "numeroCredito";
  tiposPesquisa: TipoPesquisa[] = [
    {
      label: "Número Crédito",
      valor: "numeroCredito"
    },
    {
      label: "Número Identificador da NFS-e",
      valor: "numeroNfse"
    }
  ]

  constructor(
    private service: CreditoService
  ) { }

  pesquisar(){
    this.creditos = []
    if(this.tipoPesquisaSelecionado == "numeroCredito"){
      this.service.listarPorCredito(this.pesquisa).subscribe(
        res => {
          this.creditos.push(res);
        }
      )
    }
    else {
      this.service.listarPorNumeroNfse(this.pesquisa).subscribe(
        res => {
          this.creditos = res;
        }
      )
    }
  }
}
